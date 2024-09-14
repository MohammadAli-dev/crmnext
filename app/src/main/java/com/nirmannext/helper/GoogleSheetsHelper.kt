package com.nirmannext.helper

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.SheetsScopes
import com.google.auth.http.HttpCredentialsAdapter
import com.google.auth.oauth2.GoogleCredentials
import java.io.File
import java.io.FileInputStream

class GoogleSheetsHelper {
    private lateinit var sheetsService: Sheets

    init {
        sheetsService = Sheets.Builder(
            GoogleNetHttpTransport.newTrustedTransport(),
            GsonFactory.getDefaultInstance(),
            HttpCredentialsAdapter(getCredentials())
        )
            .setApplicationName("Your App Name")
            .build()
    }

    private fun getCredentials(): GoogleCredentials {
        val credentialsFile = File("path/to/credentials.json")
        val inputStream = FileInputStream(credentialsFile)
        return GoogleCredentials.fromStream(inputStream)
            .createScoped(SheetsScopes.SPREADSHEETS_READONLY)
    }

    fun readDataFromSheet(spreadsheetId: String, range: String): String? {
        val response = sheetsService.spreadsheets().values()
            .get(spreadsheetId, range)
            .execute()
        return response.getValues().toString()
    }
}

