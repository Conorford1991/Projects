/*
Author: Conor Ford
Main file of application
*/

// Header
#include "stdafx.h"
// cryptlib.h provides basic abstractions for the Crypto++ library. 
#include "..\Crypto++\cryptlib.h"
// Crypto++ exposes most RSA encrpytion and decryption operations through aes.h.
#include "..\Crypto++\aes.h"
// Crypto++ exposes most DES encryption and decryption operations through des.h.
#include "..\Crypto++\des.h"
// AutoSeededRandomPool
#include "..\Crypto++\osrng.h"
// Input/output stream
#include <iostream>
// Stream class to both read and write from/to files.
#include <fstream>
// String class
#include <string>
// Cipher mode CBC, ECB etc.
#include "..\Crypto++\modes.h"
// The HexEncoder encodes bytes into base 16 encoded data, making it easier to display
#include "..\Crypto++\hex.h"

// namespaces
using namespace std;
using namespace CryptoPP;

void AES_call() {
	// Generate random key
	AutoSeededRandomPool rand;

	// AES max keylength = 32 bytes (256 bits)
	// AES min keylength = 24 bytes (192 bits)
	// AES default keylength = 16 bytes (128 bits)
	SecByteBlock key(AES::MAX_KEYLENGTH);

	// Generate block
	rand.GenerateBlock(key, key.size());

	// Generate random Initial Vector (IV)
	byte IV[AES::BLOCKSIZE];
	rand.GenerateBlock(IV, AES::BLOCKSIZE);

	// Encryption
	string plaintext = FileReader();

	clock_t Encryptstart = clock();

	string ciphertext = AESEncrypt(plaintext, key, IV);

	clock_t Encryptend = clock();
	double elapsed_secs = double(Encryptend - Encryptstart) / CLOCKS_PER_SEC;
	cout << "AES Time to encrypt: " << elapsed_secs << endl;

	// Decryption
	clock_t Decryptstart = clock();

	AESDecrypt(ciphertext, key, IV);

	clock_t Decryptend = clock();
	double elapsed_secs2 = double(Decryptend - Decryptstart) / CLOCKS_PER_SEC;
	cout << "AES Time to decrypt: " << elapsed_secs2 << endl;

}

void DES_call() {
	// Start time
	clock_t start = clock();

	// Generate random key
	AutoSeededRandomPool rand;

	// DES default keylength = 8 bytes
	SecByteBlock key(DES::DEFAULT_KEYLENGTH);

	// Generate block
	rand.GenerateBlock(key, key.size());

	// Generate random Initial Vector (IV)
	byte IV[DES::BLOCKSIZE];
	rand.GenerateBlock(IV, DES::BLOCKSIZE);

	string plaintext = FileReader();

	// Start time
	clock_t Encryptstart = clock();

	// Encryption
	string ciphertext = DESEncrypt(plaintext, key, IV);

	clock_t Encryptend = clock();
	double elapsed_secs = double(Encryptend - Encryptstart) / CLOCKS_PER_SEC;
	cout << "DES Encrypt time: " << elapsed_secs << endl;

	clock_t Decryptstart = clock();

	// Decryption
	DESDecrypt(ciphertext, key, IV);

	// End time
	clock_t Decryptend = clock();
	double elapsed_secs2 = double(Decryptend - Decryptstart) / CLOCKS_PER_SEC;
	cout << "DES Decrypt time: " << elapsed_secs2 << endl;
}

void TDES_call() {
	// Start time
	clock_t start = clock();

	// Generate random key
	AutoSeededRandomPool rand;

	// 3DES default keylength = 24 bytes (192 bits)
	SecByteBlock key(DES_EDE3::MAX_KEYLENGTH);

	// Generate block
	rand.GenerateBlock(key, key.size());

	// Generate random Initial Vector (IV)
	byte IV[DES_EDE3::BLOCKSIZE];
	rand.GenerateBlock(IV, DES_EDE3::BLOCKSIZE);

	string plaintext = FileReader();

	// Start time
	clock_t Encryptstart = clock();

	// Encryption
	string ciphertext = TDESEncrypt(plaintext, key, IV);

	clock_t Encryptend = clock();
	double elapsed_secs = double(Encryptend - Encryptstart) / CLOCKS_PER_SEC;
	cout << "TDES Encrypt time: " << elapsed_secs << endl;

	clock_t Decryptstart = clock();

	// Decryption
	TDESDecrypt(ciphertext, key, IV);

	// End time
	clock_t Decryptend = clock();
	double elapsed_secs2 = double(Decryptend - Decryptstart) / CLOCKS_PER_SEC;
	cout << "TDES Decrypt time: " << elapsed_secs2 << endl;
}

void Blowfish_call() {
	// Generate random key
	AutoSeededRandomPool rand;

	// Blowfish min keylength = 4 bytes 
	// Blowfish default keylength = 16 bytes 
	// Blowfish max keylength = 56 bytes
	SecByteBlock key(Blowfish::MAX_KEYLENGTH);

	// Generate block
	rand.GenerateBlock(key, key.size());

	// Generate random Initial Vector (IV)
	byte IV[Blowfish::BLOCKSIZE];
	rand.GenerateBlock(IV, Blowfish::BLOCKSIZE);

	string plaintext = FileReader();

	// Start time
	clock_t Encryptstart = clock();

	// Encryption
	string ciphertext = BlowfishEncrypt(plaintext, key, IV);

	clock_t Encryptend = clock();
	double elapsed_secs = double(Encryptend - Encryptstart) / CLOCKS_PER_SEC;
	cout << "Blowfish Time to Encrypt: " << elapsed_secs << endl;


	clock_t Decryptstart = clock();

	// Decryption
	BlowfishDecrypt(ciphertext, key, IV);

	clock_t Decryptend = clock();
	double elapsed_secs2 = double(Decryptend - Decryptstart) / CLOCKS_PER_SEC;
	cout << "Blowfish Time to Decrypt: " << elapsed_secs2 << endl;
}

void RSA_call() {
	clock_t Encryptstart = clock();
	// Generate keys
	AutoSeededRandomPool rand;

	// Instantiate RSA function
	InvertibleRSAFunction parameters;

	// Generate parameters
	// RSA add's 11 bytes to the message. So, using a 1024 (128 bytes)-bit key, you'll have 117 bytes available for the message. 
	// Therefore RSA isn't usually used to encrypt messages, it's mostly used to encrypt symmetric keys used to encrypt messages.
	parameters.GenerateRandomWithKeySize(rand, 3072);


	// Get & Print Generated Parameters
	// Modulus (message size must be smaller than the modulus size)
	const Integer n = parameters.GetModulus();
	// Prime p
	const Integer p = parameters.GetPrime1();
	// Prime q
	const Integer q = parameters.GetPrime2();
	// Private Exponent
	const Integer d = parameters.GetPrivateExponent();
	// Public Exponent
	const Integer e = parameters.GetPublicExponent();

	// Create Private Key
	RSA::PrivateKey privateKey(parameters);

	// Create Public Key
	RSA::PublicKey publicKey(parameters);

	// Get plaintext from file
	string plaintext = KeyReader();


	// Encryption
	// Using the publickey, plaintext and generated keys as parameters
	string ciphertext = RSAEncrypt(publicKey, plaintext, rand);


	clock_t Encryptend = clock();
	double elapsed_secs = double(Encryptend - Encryptstart) / CLOCKS_PER_SEC;
	cout << "RSA Time to encrypt: " << elapsed_secs << endl;


	clock_t Decryptstart = clock();

	// Decryption
	// Using the privatekey, ciphertext and generated keys as parameters
	RSADecrypt(privateKey, ciphertext, rand);

	clock_t Decryptend = clock();
	double elapsed_secs2 = double(Decryptend - Decryptstart) / CLOCKS_PER_SEC;
	cout << "RSA Time to decrypt: " << elapsed_secs2 << endl;

}

int main(){
	string plaintext = FileReader();
	cout << "Plaintext prior to encryption: " << plaintext << endl;


	AES_call();
	DES_call();
	TDES_call();
	Blowfish_call();

	string keytext = KeyReader();
	cout << "AES key prior to encryption: " << keytext << endl;

	RSA_call();
    return 0;
}


