package dogapi;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String breed = "hound";
        BreedFetcher breedFetcher = new CachingBreedFetcher(new BreedFetcherForLocalTesting());
        int result = getNumberOfSubBreeds(breed, breedFetcher);
        System.out.println(breed + " has " + result + " sub breeds");

        breed = "cat";
        result = getNumberOfSubBreeds(breed, breedFetcher);
        System.out.println(breed + " has " + result + " sub breeds");
    }

    public static int getNumberOfSubBreeds(String breed, BreedFetcher breedFetcher) {
        try {
            // Try to fetch the list of sub-breeds
            List<String> subBreeds = breedFetcher.getSubBreeds(breed);

            // If the list is empty or null, return 0
            if (subBreeds == null) {
                return 0;
            }
            return subBreeds.size();

        } catch (BreedFetcher.BreedNotFoundException e) {
            // If the breed does not exist, return -1
            return 0;
        }
    }
}