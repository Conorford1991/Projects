#include "stdafx.h"
// cryptlib.h provides basic abstractions for the Crypto++ library. 
#include "..\Crypto++\cryptlib.h"
// Crypto++ exposes most RSA encrpytion and decryption operations through rsa.h.
#include "..\Crypto++\rsa.h"
// AutoSeededRandomPool
#include "..\Crypto++\osrng.h"
// Input/output stream
#include <iostream>
// Stream class to both read and write from/to files.
#include <fstream>
// String class
#include <string>
// The HexEncoder encodes bytes into base 16 encoded data, making it easier to display
#include "..\Crypto++\hex.h"

using namespace std;
using namespace CryptoPP;

string RSAEncrypt(RSA::PublicKey publicKey, string plaintext, AutoSeededRandomPool& rand) {
	string ciphertext, encoded;

	/*Encrypter using RSA algorithm,
	OAEP (Optimal asymmetric encryption padding) padding
	SHA (Secure Hash Algorithm)
	*/
	RSAES_OAEP_SHA_Encryptor encrypt(publicKey);
	// Encryption using pipelining
	// StringSource is a source for character arrays and strings, true value indicates if the StringSource should pump all of the data immediately to its attached transformation.
	StringSource(plaintext, true,
		// Tranform the encrypted data into characters also add padding if required
		new PK_EncryptorFilter(rand, encrypt,
			/* StringSink serves as a destination for string data. The StringSink takes a reference to a string.
			Because a reference is taken, the StringSink does not own output, and therefore will not destroy output.*/
			new StringSink(ciphertext)
		)
	);

	// Print using pipelining
	StringSource(ciphertext, true,
		//The HexEncoder encodes bytes into base 16 encoded data, making it more suitable to display
		new HexEncoder(
			new StringSink(encoded)
		)
	);



	cout << "RSA (AES key) cipher text: " << encoded << endl;

	return ciphertext;
}
void RSADecrypt(RSA::PrivateKey privateKey, string ciphertext, AutoSeededRandomPool& rand) {
	string plaintext;

	/*Decrypter using RSA algorithm,
	OAEP (Optimal asymmetric encryption padding) padding
	SHA (Secure Hash Algorithm)
	*/
	RSAES_OAEP_SHA_Decryptor decrypt(privateKey);
	//StringSource is a source for character arrays and strings, true value indicates if the StringSource should pump all of the data immediately to its attached transformation.
	StringSource(ciphertext, true,
		// Tranform the encrypted data into characters and also add padding if required
		new PK_DecryptorFilter(rand, decrypt,
			/* StringSink serves as a destination for string data. The StringSink takes a reference to a string.
			Because a reference is taken, the StringSink does not own output, and therefore will not destroy output.*/
			new StringSink(plaintext)
		)
	);

	cout <<"RSA (AES key) after decryption: " <<plaintext << endl;
}