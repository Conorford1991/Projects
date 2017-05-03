'''
Author: Conor Ford
DES encryption algorithm (using the PyCryptodome class library)
'''

#Modules
# OS module
import os
# Pycryptodome classes (import of DES) & (random generator)
from Crypto.Cipher import DES
from Crypto.Random import get_random_bytes



# Encryption
def Encrypt(plaintext_bytes):
    # DES has a 8-byte block size and a variable key length 64 bits long, even though 8 bits were used for integrity
    # and do not contribute to securty. The effective key length is therefore 56 bits only.
    # Generate key
    key = get_random_bytes(8)

    # Generate intial vector
    iv = get_random_bytes(8)

    # Generate the cipher (Using Cipher Feedback Block mode)
    cipher = DES.new(key, DES.MODE_CFB, iv)

    # Generate & print the ciphertext
    ciphertext = cipher.encrypt(plaintext_bytes)
    print("DES Ciphertext: ",ciphertext)

    # return ciphertext
    return (ciphertext,iv,key)


# Decryption
def Decrypt(ciphertext,iv,key):
    # Generate the cipher (Using Cipher Feedback Block mode)
    cipher = DES.new(key, DES.MODE_CFB, iv)

    # Generate plaintext & print
    plaintext = cipher.decrypt(ciphertext)
    print("DES Plaintext: ",plaintext)




