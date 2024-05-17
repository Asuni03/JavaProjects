package com.example.maven_example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class APITutorial {
	public static void main(String[] args) {

		Transcript transcript = new Transcript();
		transcript.setAudio_url("https://storage.googleapis.com/aai-web-samples/5_common_sports_injuries.mp3");
		Gson gson = new Gson();

		String jsonRequest = gson.toJson(transcript);
		System.out.println(jsonRequest);

		//Making a request to the AssemblyAI through theirs API
		try {
			//Building the POST request
			HttpRequest postRequest = HttpRequest.newBuilder().uri(new URI("https://api.assemblyai.com/v2/transcript"))
															  .header("Authorization", Constants.APIKey)
															  .POST(BodyPublishers.ofString(jsonRequest)).build();
			
			/*
			 * After building the post request completed with the
			 * endpoint, header and body,
			 * a Client object is made to make the request
			 * (because yeah you cannot send a request without a client)
			 */
			HttpClient httpClient = HttpClient.newHttpClient();

			
			/*
			 * From HttpResponse<T>, our client object (httpclient),
			 * send the post request built and tell the body handlers(at the server side),
			 * to give back the respond in data type String
			 */
			HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
			//Other alternatives
//			HttpResponse postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
			System.out.println(postResponse.body());
			
			
			
			//Making GET call
			

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
