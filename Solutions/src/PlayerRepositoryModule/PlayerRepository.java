package PlayerRepositoryModule;

import java.util.ArrayList;

public class PlayerRepository {
	
	private ArrayList<Player> players;
	private int numberOfDefenders;
	private int numberOfMidFielders;
	private int numberOfForwards;
	private int numberOfGoalKeepers;
	
	
	
	public PlayerRepository() {
		players = new ArrayList<>();
	}
	
	
	
	public void addPlayer(Player p) throws PlayerAlreadyExistsException { // Mentor Comment : parameter could have been named as player
	    // Mentor Comment: Check if p is equal to null and return immediately if null...
		// Mentor Comment: What will happen if p==null (the caller calling addPlayer(null) )
		for (Player storedPlayer : players) { //Mentor comment: it is good practice to use "this" when you refer a instance field e.g this.players 
			if (storedPlayer.equals(p)) {
				throw new PlayerAlreadyExistsException("This player already exists in the repository.");
			}
		}
		
		String category = p.getCategory();
		// Mentor Comment : Ensure category is not null before using in switch
		// Use category.equalsIgnoreCase() in switch condition

		switch (category) {
		case "Defender": numberOfDefenders++; break;
		case "Midfielder": numberOfMidFielders++; break;
		case "Forward": numberOfForwards++; break;
		case "Goalkeeper": numberOfGoalKeepers++; break;
		}
		
		players.add(p);
	}
	
	
	
	public String formTeam() throws TeamNotFormedException {
		if (numberOfDefenders < 4 || numberOfMidFielders < 3 || numberOfForwards < 3 || numberOfGoalKeepers < 1) {
			throw new TeamNotFormedException("There are not enough players to form a team. Current number of players in each category:\n"
					+ "Number of Defenders: " + numberOfDefenders + " (4 required)\n"
							+ "Number of Midfielders: " + numberOfMidFielders + " (3 required)\n"
									+ "Number of Forwards: " + numberOfForwards + " (3 required)\n"
											+ "Number of Goalkeepers: " + numberOfGoalKeepers + " (1 required)\n");

			//Mentor Comment : The above error message is very lengthy and has many concatenations..Consider using String Buffer for forming the message and use it with Exception object creation

		}
		else {
			StringBuilder sb = new StringBuilder("Team formed with 11 players:\n"
					+ "S No., Player Name, Category, Rank\n");
			int addedDefenders = 0;
			int addedMidFielders = 0;
			int addedForwards = 0;
			int addedGoalKeepers = 0;
			
			for (int i = 0; i < players.size(); i++) {
				Player currentPlayer = players.get(i);
				boolean shouldBeAdded = false;
				

				// Mentor Comment : use equalsIgnoreCase on String objects
				if (addedDefenders < 4 && currentPlayer.getCategory().equals("Defender")) {
					addedDefenders++;
					shouldBeAdded = true;
				}
				else if (addedMidFielders < 3 && currentPlayer.getCategory().equals("Midfielder")) {
					addedMidFielders++;
					shouldBeAdded = true;
				}
				else if (addedForwards < 3 && currentPlayer.getCategory().equals("Forward")) {
					addedForwards++;
					shouldBeAdded = true;
				}
				else if (addedGoalKeepers < 1 && currentPlayer.getCategory().equals("Goalkeeper")) {
					addedGoalKeepers++;
					shouldBeAdded = true;
				}
				
				if (shouldBeAdded) {
					sb.append((i+1) + ", " + currentPlayer.getName() + ", " + currentPlayer.getCategory() +
							", " + currentPlayer.getRank() + "\n");
				}
				
				if (addedDefenders == 4 && addedMidFielders == 3 && addedForwards == 3 && addedGoalKeepers == 1) {
					break;
				}
			}
			
			return sb.toString();
			
		}
	}

}
