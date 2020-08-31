package com.deepak.healthedge_toyshop;

import java.util.List;
import java.util.stream.Collectors;

public class ToyCatalogue {

	private List<Toy> toys;

	public ToyCatalogue(List<Toy> toys) {
		this.toys = toys;
	}

	// Assumption: A toy's price can not be zero or negative
	public int getMaxNumberOfToysForGivenAmount(int givenAmount) {
		int maxNumberOfToys = 0;

		List<Toy> sortedToyOnBasisOfPrice = toys.stream()
				.sorted((toy1, toy2) -> toy1.getPrice().compareTo(toy2.getPrice())).collect(Collectors.toList());

		for (Toy toy : sortedToyOnBasisOfPrice) {

			if (givenAmount / toy.getPrice() <= 0) {
				break;
			} else {
				int quantityOfToyForGivenAmount = givenAmount / toy.getPrice();
				int remainingAmount = givenAmount % toy.getPrice();

				if (quantityOfToyForGivenAmount <= toy.getQuantity()) {
					maxNumberOfToys = maxNumberOfToys + quantityOfToyForGivenAmount;
				} else {
					maxNumberOfToys = maxNumberOfToys + toy.getQuantity();
					remainingAmount = remainingAmount
							+ (quantityOfToyForGivenAmount - toy.getQuantity()) * toy.getPrice();
				}

				givenAmount = remainingAmount;
			}
		}

		return maxNumberOfToys;
	}

}
