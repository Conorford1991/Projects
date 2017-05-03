'''
Author: Conor Ford
Blowfish encryption algorithm (using the PyCryptodome class library)
'''

#Modules
# OS module
import os
# Pycryptodome classes (import of Blowfish) & (random generator)
from Crypto.Cipher import Blowfish
from Crypto.Random import get_random_bytes



# Encryption
def Encrypt(plaintext_bytes):
    # Blowfish has a 64-bit block size and a variable key length from 32 bits up to 448 bits
    # Generate key
    key = get_random_bytes(56)

    # Generate initial vector
    iv = get_random_bytes(8)

    # Generate the cipher (Using Cipher Feedback Block mode)
    cipher = Blowfish.new(key, Blowfish.MODE_CFB, iv)

    # Generate & print the ciphertext
    ciphertext = cipher.encrypt(plaintext_bytes)
    print("Blowfish Ciphertext: ",ciphertext)

    # return ciphertext
    return (ciphertext,iv,key)


# Decryption
def Decrypt(ciphertext,iv,key):
    # Generate the cipher (Using Cipher Feedback Block mode)
    cipher = Blowfish.new(key, Blowfish.MODE_CFB, iv)

    # Generate plaintext & print
    plaintext = cipher.decrypt(ciphertext)
    print("Blowfish Plaintext: ",plaintext)

