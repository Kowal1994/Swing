package calculator;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import windowMain.Table;

public class Calculator {		
	
	public static String count(Integer operation) {

		switch (operation) {
        case 0: 
        		Integer sum = Table.getInstance().tableToLisUsers().stream().mapToInt(u -> u.getPlaca()).sum();	
        		if(sum>0) {
        			return ("Suma wszystkich p³ac wynosi " +sum);
        		} else {
        			return ("Wprowadz uzytkowników");
        		}
        case 1: 
        		OptionalDouble average = Table.getInstance().tableToLisUsers().stream().mapToInt(i -> i.getPlaca()).average();	
        		if(average.isPresent()) {
            		return ("Srednia wynosi " + average.getAsDouble());	
            	} else {
            		return ("Wprowadz uzytkowników");
            	}
        case 2:  {
        		OptionalInt max = Table.getInstance().tableToLisUsers().stream().mapToInt(u -> u.getPlaca()).max();
        		OptionalInt min = Table.getInstance().tableToLisUsers().stream().mapToInt(u -> u.getPlaca()).min();
        		if(max.isPresent()) {
        		return ("Maksimium wynosi " + max.getAsInt() + " a miniumu wynosi " + min.getAsInt());	
        		} else {
        			return ("Wprowadz uzytkowników");
        		}
        	}	

		}
		return null;
	}	
}
