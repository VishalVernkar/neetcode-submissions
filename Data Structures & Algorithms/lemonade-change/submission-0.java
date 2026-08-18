class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] notes = new int[3];
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                notes[0]++;
            } else if(bills[i] == 10){
                notes[1]++;
                if(notes[0] > 0){
                    notes[0]--;
                } else {
                    return false;
                }
            } else if(bills[i] == 20){
                notes[2]++;
                if(notes[0] > 0 && notes[1] > 0){
                    notes[0]--;
                    notes[1]--;
                } else if(notes[0] > 2){
                    notes[0] -= 2;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

// 5, 10, 20 - bills
// I have zeroof them first
// at a point 
// I can choose to give a change or collect to next customer - to see if I can give from future

// How do I know which change to give
// I have 5 10 20
// if it is 15 - i can give 5, 5, 5 or 5, 10

// 15 - 




// bills=[5,20,10,5]
// 0 15 5 0

// 2 1 1

// 