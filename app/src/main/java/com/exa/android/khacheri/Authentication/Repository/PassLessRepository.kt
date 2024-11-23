package com.exa.android.khacheri.Authentication.Repository

import com.exa.android.khacheri.utils.Response
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class PasswordLessRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    fun isUserLoggedIn(): Boolean = firebaseAuth.currentUser != null

    fun sendSignInLink(email: String): Flow<Response<Boolean>> = flow {
        emit(Response.Loading)
        val actionCodeSettings = ActionCodeSettings.newBuilder()
            .setUrl("https://loopit.page.link/XktS/signIn")
            .setHandleCodeInApp(true)
            .setAndroidPackageName("com.exa.android.khacheri", true, null)
            .build()


        try {
            val result = suspendCancellableCoroutine { continuation ->
                firebaseAuth.sendSignInLinkToEmail(email, actionCodeSettings)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Resume the coroutine with a successful result
                            continuation.resume(true)
                        } else {
                            // Resume the coroutine with an exception for error handling, from here it will direct to catch block
                            continuation.resumeWithException(
                                task.exception ?: Exception("Unknown Error")
                            )
                        }
                    }
            }
            emit(Response.Success(result))
        } catch (e: Exception) {
            // Emit an error response when an exception is caught
            emit(Response.Error(e.localizedMessage ?: "Error sending sign-in link"))
        }
    }

    fun verifySignInLink(email: String, link: String): Flow<Response<Boolean>> = flow {
        emit(Response.Loading)
        if (firebaseAuth.isSignInWithEmailLink(link)) {
            Tasks.await(firebaseAuth.signInWithEmailLink(email, link))
            emit(Response.Success(true))  // .await() internally handles completeListener so need to mix completeListener explicitly as above
        } else {
            emit(Response.Error(message = "Invalid link"))
        }
    }

    fun signOut() {
        firebaseAuth.signOut()
    }
}

/*
suspendCancellableCoroutine: This is a suspending function that safely integrates with asynchronous
callbacks and supports coroutine cancellation.
continuation.resume(): Resumes the suspended coroutine with a successful result.
continuation.resumeWithException(): Resumes the coroutine with an exception, allowing it to be caught
and handled in the catch block.
This way, you can emit Response.Success only when the operation is successful and emit Response.
Error when the task fails or an exception occurs.
 */
