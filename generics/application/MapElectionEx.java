package generics.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MapElectionEx {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votes = new LinkedHashMap<>(); 
		
		System.out.println("Enter the file path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
				
				String fields[] = line.split(",");
				String name = fields[0];
				
				int count = Integer.parseInt(fields[1]);
				
				if(votes.containsKey(name)) {
					int votesTest = votes.get(name);
					votes.put(name, count + votesTest);
				}
				else {
					votes.put(name, count);
				}
				
				line = br.readLine();
			}
			System.out.println("TOTAL VOTES: ");
			for(String key : votes.keySet()) {
				System.out.println(key + " : " + votes.get(key));
			}
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}
}
