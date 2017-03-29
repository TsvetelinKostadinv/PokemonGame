package main;

import pokemon.Pokemon;

public class PokemonResolver {
	
	public static Pokemon decideWhosTypeISStronger(Pokemon pokemonA, Pokemon pokemonB)
	{
		String attributeOfA = pokemonA.getPrimaryAttr();
		String attributeOfB = pokemonB.getPrimaryAttr();
		
		switch(attributeOfA)
		{
		case "grass": switch(attributeOfB)
					{
					//good against
					case "ground":case "rock":
					case "water": return pokemonA;
					
					//weak against
					case "flying":case "poison":
					case "bug":case "fire":
					case "grass": return pokemonB;
					}
		case "fire": switch(attributeOfB)
					{
					case "bug":
					case "grass": return pokemonA;
		
					case "rock":case "fire":
					case "water": return pokemonB;
					}
		case "water": switch(attributeOfB)
					{
					case "ground":case "rock":
					case "fire": return pokemonA;

					case "water":case "grass": return pokemonB;
					}
		case "normal": switch(attributeOfB)
					{
					case "rock":
					case "ghost": return pokemonB;
					}
		case "bug": switch(attributeOfB)
					{
					case "grass": return pokemonA;

					case "fighting":case "flying":
					case "fire": return pokemonB;
					}
		case "electricity": switch(attributeOfB)
							{
							case "flying":
							case "water": return pokemonA;

							case "grass":
							case "electricity": return pokemonB;
							}
		case "rock": switch(attributeOfB)
					{
					case "flying":case "bug":
					case "fire": return pokemonA;

					case "fighting":
					case "ground": return pokemonB;
					}
		case "ghost": switch(attributeOfB)
					{
					case "ghost": return pokemonA;

					case "normal": return pokemonB;
					}
		case "fighting": switch(attributeOfB)
						{
						case "normal":case "rock": return pokemonA;

						case "poison":case "flying":
						case "bug": return pokemonB;
						}
		case "flying": switch(attributeOfB)
					{
					case "grass":case "bug":
					case "fighting": return pokemonA;

					case "rock":
					case "electricity":return pokemonB;
					}
		default: return null;
		}
		
		
		
		//grass +ground/rock/water -flying/poison/bug/steel/fire/grass/dragon

		//fire +bug/steel/grass/ice -rock/fire/water/dragon

		//water +ground/rock/fire -water/grass/dragon

		//normal -rock/steel --ghost

		//bug +grass/psychic/dark -fighting/flying/poison/ghost/steel/fire/fairy

		//electricity +flying/water -grass/electricity/dragon --ground 

		//rock +flying/bug/fire/ice -fight/ground/steel	

		//ghost +ghost/psychic --normal

		//fighting +normal/rock/steel/ice/dark -flying/poison/bug/psychic/fairy

		//flying +grass/bug/fighting -rock/steel/electric
	}
	
}
