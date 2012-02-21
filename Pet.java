/*
 * Noah Alonso-Torres
 * PetStore Sort
 * Pet Class
 */


public class Pet {
	
	public String name;
	public int quantity = 0;
	
	public Pet(String paraName, int paraQuantity) {
		name = paraName;
		quantity = paraQuantity;
	}
	
	public int compareCount(Pet p) {
		if (p.quantity == quantity) return 0;
		else if (p.quantity > quantity) return 1;
		else if (p.quantity < quantity) return -1;
		//Just to make it happy
		else return 2;
	}

	public int compareName(Pet p) {
		String tempName = name.toLowerCase();
		String tempPName = p.name.toLowerCase();
		
		int value = tempName.compareTo(tempPName);
		return value;
	}

	public int getCount() {
		return quantity;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		String humanFriendly = name + " " + quantity;
		return humanFriendly;
	}
}
