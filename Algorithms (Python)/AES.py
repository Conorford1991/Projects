'''
Author: Conor Ford
AES class
'''

#Modules
# Pycryptodome classes (import of RSA) & (random generator)
from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes
from FileReader import FileReader

class Aes:

 # Encryption
 def Encrypt(self,plaintext):
    # AES 256 (32 bytes) has still an IV of 16 bytes
    # Generate key
    key = get_random_bytes(32)

    # Generate intial vector
    iv = get_random_bytes(16)

    # Generate the cipher (Using Cipher Feedback Block mode)
    cipher = AES.new(key, AES.MODE_CFB, iv)

    # Generate & print the ciphertext
    ciphertext = cipher.encrypt(plaintext)


    FileReader().EncryptedFileWriter(str(ciphertext), "AES")
    print("AES encryption complete. Ciphertext write to file sucessful")

    # return ciphertext
    return (ciphertext,iv,key)


# Decryption
 def Decrypt(self,ciphertext,iv,key):
    # Generate the cipher (Using Cipher Feedback Block mode)
    cipher = AES.new(key, AES.MODE_CFB, iv)

    # Generate plaintext & print
    plaintext = cipher.decrypt(ciphertext)

    FileReader().DecryptedFileWriter(str(plaintext), "AES")
    print("AES decryption complete. Plaintext write to file sucessful")


