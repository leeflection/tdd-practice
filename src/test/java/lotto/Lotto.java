package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if(isDuplicated(numbers)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Integer> numbers){
        long count = numbers.stream().distinct()
                .count();
        if(count != numbers.size()){
            return true;
        }
        return false;
    }

}