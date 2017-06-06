'''
Author: Conor Ford
DES class
'''

#Modules
# Pycryptodome classes (import of DES) & (random generator)
from Crypto.Cipher import DES
from Crypto.Random import get_random_bytes
from FileReader import FileReader


class Des:

# Encryption
 def Encrypt(self,plaintext_bytes):
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

    FileReader().EncryptedFileWriter(str(ciphertext), "DES")
    print("DES encryption complete. Ciphertext write to file sucessful")

    # return ciphertext
    return (ciphertext,iv,key)


# Decryption
 def Decrypt(self,ciphertext,iv,key):
    # Generate the cipher (Using Cipher Feedback Block mode)
    cipher = DES.new(key, DES.MODE_CFB, iv)

    # Generate plaintext & print
    plaintext = cipher.decrypt(ciphertext)

    FileReader().DecryptedFileWriter(str(plaintext), "DES")
    print("DES decryption complete. Plaintext write to file sucessful")




