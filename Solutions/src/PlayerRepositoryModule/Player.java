package PlayerRepositoryModule;

import java.util.Objects;

public class Player {
	
	private String name;
	private String category = null;
	private int rank = 0;
	
	
	
	public Player(String name) {
		this.name = name;
	}
	
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) throws InvalidPlayerInformationException {

		// Mentor Comment:
		// You shall use category.equalsIgnoreCase()

		if (category.equals("Defender") || category.equals("Midfielder") || category.equals("Forward") || category.equals("Goalkeeper")) {
			this.category = category;
		}
		else {
			throw new InvalidPlayerInformationException("The specified category could not be found.");
		}
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) throws InvalidPlayerInformationException {
		if (rank >= 1) {
			this.rank = rank;
		}
		else {
			throw new InvalidPlayerInformationException("Player rank should be greater or equal than 1.");
		}
	}
	
	
	
	@Override
	public String toString() {
		return name + ", " + category + ", " + rank;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(category, name, rank);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(category, other.category) && Objects.equals(name, other.name) && rank == other.rank;
	}

}
