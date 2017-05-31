'''
Author: Conor Ford
TDES class
'''

#Modules
# OS module
import os
# Pycryptodome classes (import of AES) & (random generator)
from Crypto.Cipher import DES3
from Crypto.Random import get_random_bytes
import FileReader

# Encryption
def Encrypt(plaintext_bytes):
    # 3DES has a 64-bit block size and a variable key length 168, 112 or 56 bits
    # Generate key
    key = get_random_bytes(24)

    # Generate intial vector
    iv = get_random_bytes(8)

    # Generate the cipher (Using Cipher Feedback Block mode)
    cipher = DES3.new(key, DES3.MODE_CFB, iv)

    # Generate & print the ciphertext
    ciphertext = cipher.encrypt(plaintext_bytes)

    FileReader.EncryptedFileWriter(str(ciphertext), "TDES");
    print("TDES encryption complete. Ciphertext write to file complete")

    # return ciphertext
    return (ciphertext,iv,key)


# Decryption
def Decrypt(ciphertext,iv,key):
    # Generate the cipher (Using Cipher Feedback Block mode)
    cipher = DES3.new(key, DES3.MODE_CFB, iv)

    # Generate plaintext & print
    plaintext = cipher.decrypt(ciphertext)

    FileReader.DecryptedFileWriter(str(plaintext), "TDES");
    print("TDES decryption complete. Plaintext write to file complete")



