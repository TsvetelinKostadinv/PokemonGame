package main;

import pokemon.Pokemon;
import pokemon.*;

public class PokemonResolver {
	
	public static Pokemon decideWhosTypeISStronger(Pokemon pokemonAttacker, Pokemon pokemonDefender, int attackerAttack/*, boolean isThePlayerAttacking*/)
	{
		
		Pokemon MissingNo = new MissingNo();
		//WE GO UNDER THE PRESUMPTION THAT
		//1 and 2 are normal typed moves shared among all pokemon
		//move 3 is the main/primary move of each pokemon which shares its typing (fire, water, etc.)
		//move 4 is the secondary move of each pokemon which can either share its main type or
		//if it has dual typing, share its second typing
		
		String attributeOfTheAttackingPokemonsAttack = null, attributeOfTheDefendingPokemon = null;

		//1 - Tackle and 2 - HyperFang are both normal attacks, shared among all pokemon
		/*
		if (attackerAttack == 1 || attackerAttack == 2) {
			if (isThePlayerAttacking) {
				attributeOfA = "normal";
				attributeOfB = pokemonB.getPrimaryAttr();
			} else if (!isThePlayerAttacking) {
				attributeOfA = pokemonA.getPrimaryAttr();
				attributeOfB = "normal";
			}
		}
		
		if (attackerAttack == 3) {
			attributeOfA = pokemonA.getPrimaryAttr();
			attributeOfB = pokemonB.getPrimaryAttr();
		} else if (attackerAttack == 4) {
			if (isThePlayerAttacking) {
				attributeOfA = pokemonA.getSecondaryAttr();
				attributeOfB = pokemonB.getPrimaryAttr();
			} else if (!isThePlayerAttacking) {
				attributeOfA = pokemonA.getPrimaryAttr();
				attributeOfB = pokemonB.getSecondaryAttr();
			}
		}
		*/
		
		//let's only look at the player
		if (attackerAttack == 1 || attackerAttack == 2) {
			attributeOfTheAttackingPokemonsAttack = "normal";
		} else if (attackerAttack == 3) {
			attributeOfTheAttackingPokemonsAttack = pokemonAttacker.getPrimaryAttr();
		} else if (attackerAttack == 4) {
			attributeOfTheAttackingPokemonsAttack = pokemonAttacker.getSecondaryAttr();
		}
		
		attributeOfTheDefendingPokemon = pokemonDefender.getPrimaryAttr();
		
		switch (attributeOfTheAttackingPokemonsAttack) {
		case "grass":
			switch (attributeOfTheDefendingPokemon) {
			// good against
			case "ground":
			case "rock":
			case "water":
				return pokemonAttacker;

				// weak against
			case "flying":
			case "poison":
			case "bug":
			case "fire":
			case "grass":
				return pokemonDefender;

			default:
				return MissingNo;
			}
		case "fire":
			switch (attributeOfTheDefendingPokemon) {
			case "bug":
			case "grass":
				return pokemonAttacker;

			case "rock":
			case "fire":
			case "water":
				return pokemonDefender;

			default:
				return MissingNo;	
			}
		case "water":
			switch (attributeOfTheDefendingPokemon) {
			case "ground":
			case "rock":
			case "fire":
				return pokemonAttacker;

			case "water":
			case "grass":
				return pokemonDefender;

			default:
				return MissingNo;	
			}
		case "normal":
			switch (attributeOfTheDefendingPokemon) {
			case "rock":
			case "ghost":
				return pokemonDefender;
			
			default:
				return MissingNo;
			}
		case "bug":
			switch (attributeOfTheDefendingPokemon) {
			case "grass":
				return pokemonAttacker;

			case "fighting":
			case "flying":
			case "fire":
				return pokemonDefender;
				
			default:
				return MissingNo;	
			}
		case "electricity":
			switch (attributeOfTheDefendingPokemon) {
			case "flying":
			case "water":
				return pokemonAttacker;

			case "grass":
			case "electricity":
				return pokemonDefender;

			default:
				return MissingNo;	
			}
		case "rock":
			switch (attributeOfTheDefendingPokemon) {
			case "flying":
			case "bug":
			case "fire":
				return pokemonAttacker;

			case "fighting":
			case "ground":
				return pokemonDefender;

			default:
				return MissingNo;	
			}
		case "ghost":
			switch (attributeOfTheDefendingPokemon) {
			case "ghost":
				return pokemonAttacker;

			case "normal":
				return pokemonDefender;

			default:
				return MissingNo;	
			}
		case "fighting":
			switch (attributeOfTheDefendingPokemon) {
			case "normal":
			case "rock":
				return pokemonAttacker;

			case "poison":
			case "flying":
			case "bug":
				return pokemonDefender;

			default:
				return MissingNo;	
			}
		case "flying":
			switch (attributeOfTheDefendingPokemon) {
			case "grass":
			case "bug":
			case "fighting":
				return pokemonAttacker;

			case "rock":
			case "electricity":
				return pokemonDefender;

			default:
				return MissingNo;	
			}
		default:
			return null;
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
