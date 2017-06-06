'''
Author: Conor Ford
Blowfish class
'''

#Modules
# Pycryptodome classes (import of Blowfish) & (random generator)
from Crypto.Cipher import Blowfish
from Crypto.Random import get_random_bytes
from FileReader import FileReader

class Bf:


# Encryption
 def Encrypt(self,plaintext_bytes):
    # Blowfish has a 64-bit block size and a variable key length from 32 bits up to 448 bits
    # Generate key
    key = get_random_bytes(56)

    # Generate initial vector
    iv = get_random_bytes(8)

    # Generate the cipher (Using Cipher Feedback Block mode)
    cipher = Blowfish.new(key, Blowfish.MODE_CFB, iv)

    # Generate & print the ciphertext
    ciphertext = cipher.encrypt(plaintext_bytes)

    FileReader().EncryptedFileWriter(str(ciphertext), "Blowfish")
    print("Blowfish encryption complete. Ciphertext write to file sucessful")

    # return ciphertext
    return (ciphertext,iv,key)


# Decryption
 def Decrypt(self,ciphertext,iv,key):
    # Generate the cipher (Using Cipher Feedback Block mode)
    cipher = Blowfish.new(key, Blowfish.MODE_CFB, iv)

    # Generate plaintext & print
    plaintext = cipher.decrypt(ciphertext)

    FileReader().DecryptedFileWriter(str(plaintext), "Blowfish")
    print("Blowfish decryption complete. Plaintext write to file sucessful")

