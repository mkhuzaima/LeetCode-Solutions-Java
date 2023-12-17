// id: 2353
// Name: Design a Food Rating System
// link: https://leetcode.com/problems/design-a-food-rating-system/
// Difficulty: Medium

class FoodRatings {

    class FoodItem implements Comparable<FoodItem> {
        String food, cuisine;
        int rating;
        public FoodItem(String food, String cuisine, int rating) {
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }
        public int compareTo(FoodItem other) {
            if (other.rating != this.rating) {
                return other.rating - this.rating; // reversed
            }
            return this.food.compareTo(other.food);
        }
    }
    
    Map<String, FoodItem> map; // food name to item
    Set<FoodItem> set;          // sorted set

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        set = new TreeSet<>();
        for (int i = 0; i < foods.length; i++) {
            FoodItem fi = new FoodItem(foods[i], cuisines[i], ratings[i]);
            map.put(foods[i], fi);
            set.add(fi);
        }
    }
    
    public void changeRating(String food, int newRating) {
        FoodItem fi = map.get(food);
        set.remove(fi);         // reinsert in set to keep sorted
        fi.rating = newRating;
        set.add(fi);
    }
    
    public String highestRated(String cuisine) {
        Iterator<FoodItem> it = set.iterator();

        while (it.hasNext()) {
            FoodItem fi = it.next();
            if (fi.cuisine.equals(cuisine)) {
                return fi.food;
            }
        }
        return null;
    }
}

