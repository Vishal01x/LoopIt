package com.exa.android.khacheri.utils

import android.os.Build
import androidx.annotation.RequiresApi
import org.whispersystems.libsignal.*
import org.whispersystems.libsignal.state.impl.InMemorySignalProtocolStore
import org.whispersystems.libsignal.protocol.SignalMessage
import org.whispersystems.libsignal.util.KeyHelper
import java.util.Base64
/*
object EncryptionUtil {
    private val identityKeyPair = KeyHelper.generateIdentityKeyPair()
    private val registrationId = KeyHelper.generateRegistrationId(false)
    private val signalProtocolStore = InMemorySignalProtocolStore(identityKeyPair, registrationId)

    @RequiresApi(Build.VERSION_CODES.O)
    fun encryptMessage(recipientId: String, recipientPublicKey: String, message: String): String {
        val recipientAddress = SignalProtocolAddress(recipientId, 1)
        val recipientKey = IdentityKeyPair(Base64.getDecoder().decode(recipientPublicKey))

        val sessionBuilder = SessionBuilder(signalProtocolStore, recipientAddress)
        sessionBuilder.processPreKeyBundle(recipientKey)

        val sessionCipher = SessionCipher(signalProtocolStore, recipientAddress)
        val ciphertext = sessionCipher.encrypt(message.toByteArray())
        return Base64.getEncoder().encodeToString(ciphertext.serialize())
    }

    fun decryptMessage(senderId: String, encryptedMessage: String): String {
        val senderAddress = SignalProtocolAddress(senderId, 1)
        val sessionCipher = SessionCipher(signalProtocolStore, senderAddress)
        val decryptedBytes = sessionCipher.decrypt(SignalMessage(Base64.getDecoder().decode(encryptedMessage)))
        return String(decryptedBytes)
    }
}
*/