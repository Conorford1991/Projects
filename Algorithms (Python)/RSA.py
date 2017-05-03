'''
Author: Conor Ford
RSA encryption algorithm (using the PyCryptodome class library)
RSA add's 11 bytes to the message. So, using a 1024 (128 bytes)-bit key, you'll have 117 bytes available for the message.
Therefore RSA isn't usually used to encrypt messages, it's mostly used to encrypt symmetric keys used to encrypt messages.
'''

#Modules
# OS module
import os
# Pycryptodome classes (import of RSA) & (random generator)
from Crypto.PublicKey import RSA
from Crypto import Random
from Crypto.Cipher import PKCS1_OAEP

def Encrypt(plaintext):
    # Random generator
    random_generator = Random.new().read

    # Generate public and private keys with size of 3072 bits
    key = RSA.generate(3072, random_generator)

    # Generate cipher with public key (Public-Key Cryptography Standards_Optimal asymmetric encryption padding)
    cipher = PKCS1_OAEP.new(key)

    # Encrypt
    ciphertext = cipher.encrypt(plaintext)
    print("RSA (AES key) Ciphertext: ",ciphertext)

    return (ciphertext,key,cipher)

def Decrypt(ciphertext,key,cipher):

    # Decrypt with private key
    plaintext = cipher.decrypt(ciphertext)
    print("RSA (AES key) after decryption: ",plaintext)

    return plaintext







