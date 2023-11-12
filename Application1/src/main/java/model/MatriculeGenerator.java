package model;

import java.util.HashMap;
import java.util.Map;

public class MatriculeGenerator {
    // Map to store the last used sequential number for each year
    private static final Map<Integer, Long> yearToSequentialNumberMap = new HashMap<>();
    private static final Object lock = new Object();

    // Method to generate a unique Matricule as a Long
    public static Long generateMatricule(int year, long sequentialNumber) {
        synchronized (lock) {
            // Get the last used sequential number for the given year
            long lastSequentialNumber = yearToSequentialNumberMap.getOrDefault(year, 0L);

            // If the provided sequentialNumber is less than the last used, use the last used + 1
            sequentialNumber = Math.max(lastSequentialNumber + 1, sequentialNumber);

            // Update the map with the new sequential number for the year
            yearToSequentialNumberMap.put(year, sequentialNumber);

            // Combine the year and sequentialNumber to create a unique Long Matricule
            return Long.parseLong(String.format("%d%04d", year, sequentialNumber));
        }
    }

    // Method to generate a unique Matricule as a Long without providing a sequential number
    public static Long generateMatricule(int year) {
        // Use the method above with a placeholder sequential number (1)
        return generateMatricule(year, 1);
    }
}

