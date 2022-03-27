package br.com.joaofzm15.yugiohstats.frontEnd.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Player;

public class HttpController {

	public static HttpResponse<String> getUrl(String url) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().GET().header("accept", "application/json").uri(URI.create(url))
				.build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return response;
	}

	public static List<Player> parseJsonIntoPlayer(HttpResponse<String> response) {
		ObjectMapper mapper = new ObjectMapper();
		List<Player> players = null;
        try {
			players = mapper.readValue(response.body(), new TypeReference<List<Player>>() {});
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return players;
	}
	
}
