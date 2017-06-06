'''
Author: Conor Ford
RSA class
'''

#Modules
# Pycryptodome classes (import of RSA) & (random generator)
from Crypto.PublicKey import RSA
from Crypto import Random
from Crypto.Cipher import PKCS1_OAEP
from FileReader import FileReader

class Rsa:

 def Encrypt(self,plaintext):
    # Random generator
    random_generator = Random.new().read

    # Generate public and private keys with size of 3072 bits
    key = RSA.generate(3072, random_generator)

    # Generate cipher with public key (Public-Key Cryptography Standards_Optimal asymmetric encryption padding)
    cipher = PKCS1_OAEP.new(key)

    # Encrypt
    ciphertext = cipher.encrypt(plaintext)

    FileReader().EncryptedFileWriter(str(ciphertext), "RSA")
    print("RSA encryption complete. Ciphertext write to file sucessful")

    return (ciphertext,key,cipher)

 def Decrypt(self,ciphertext,key,cipher):

    # Decrypt with private key
    plaintext = cipher.decrypt(ciphertext)

    FileReader().DecryptedFileWriter(str(plaintext), "RSA")
    print("RSA decryption complete. Plaintext write to file sucessful")

    return plaintext







