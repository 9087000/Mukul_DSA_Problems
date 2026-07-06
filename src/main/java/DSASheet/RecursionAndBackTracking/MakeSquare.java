package DSASheet.RecursionAndBackTracking;

import java.util.Arrays;

public class MakeSquare {
    public static void main(String[] args) {
        int[] matchSticks = {1,1,2,2,2};
        boolean sticks = makesqaure(matchSticks);
        System.out.println(sticks);
    }
    //optimized
    // Same backTracking, but reduce unnecessary branches
    // Sort the matchsticks
    // Take the largest stick first
    // If one side fails, dont try for another side
    // find sum
    // if sum % 4 == 0
    // false
    // target = sum / 4
    // sort the matchStick
    // Start from last because last has the largest stick
    // recurse it using index - 1
    // Try to place first stick
    // if side[i] + target > target
    // skip
    // place the stick
    // Recurse it using index - 1
    // remove the stick
    // if(side[i] == 0)
    // break
    // T.C: o(4^n)
    // S.C: o(n)
    // sum = 0
    // stick : matchSticks
    // sum+=stick
    // if(sum % 4 != 0)
    // false
    // target = sum / 4
    // Arrays.sort(matchSticks)
    // side[] = new int[4]
    // solve(matchSticks.length - 1, matchSticks, side, target)
    // solve(int index, int[] matchSticks, int[] side, int target) :
    // if(index < 0)
    // return side[0] == target &&
    //        side[1] == target &&
    //        side[2] == target &&
    //        side[3] == target;
    // stick = matchSticks[index]
    // for int i from 0 to 4
    // if(side[i] + stick > target)
    // continue
    // side[i]+=stick
    // if(solve(index-1, matchSticks, side, target) :
    // return true
    // side[i]-=stick
    // if(side[i] == 0)
    // break
    // return false
    private static boolean makesqaure(int[] matchSticks) {
        int sum = 0;

        for(int stick : matchSticks) {
            sum+=stick;
        }

        if(sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        Arrays.sort(matchSticks);
        int[] side = new int[4];

        return solve(matchSticks.length - 1, matchSticks, side, target);
    }
    private static boolean solve(int index, int[] matchSticks, int[] side, int target) {
        if(index < 0) {
            return side[0] == target &&
                   side[1] == target &&
                   side[2] == target &&
                   side[3] == target;
        }

        int stick = matchSticks[index];

        for(int i=0; i<4; i++) {
            if(side[i] + stick > target) {
                continue;
            }

            side[i]+=stick;

            if(solve(index- 1, matchSticks, side, target)) {
                return  true;
            }

            side[i]-=stick;

            if(side[i]==0) {
                break;
            }
        }

        return false;
    }
    //brute
    // take each matchStick and try to place it in one of four sides
    // target = totalSum/ 4
    // Find Sum
    // if(sum % 4  !=0)
    // false
    // create side array with size of 4
    // target = sum / 4
    // recurse it with starting from 0
    // solve(0, matchSticks, side, target)
    // solve(int index, int[] matchSticks, int[] side, int target)
    // pick current stick
    // Stick = matchSticks[index]
    // Try placing stick in 0,1,2,3
    // if side[i] + stick <= target
    // place it
    // Recursion
    // if(solve(index, matchSticks, side, target)
    // true
    // Recurse for next stack
    // remove it
    // Check if all sticks placed
    // check all 4 sides == target
    // T.C : o(4^n)
    // S.C : o(n)
    // sum = 0
    // for int stick : matchSticks
    // sum += stick
    // if(sum % 4 !=0)
    // return false
    // target = sum / 4
    // int[] side = new int[4]
    // solve(0, matchSticks, side, target)
    // solve(int index, int[] matchSticks, int[] side, int target) :
    // if(index == matchSticks.length)
    // return side[0] == target &&
    //        side[1] == target &&
    //        side[2] == target &&
    //        side[3] == target
    // stick = matchSticks[index]
    // for int i from 0 to 4:
    // if(side[i] + stick <= target)
    // side[i]+=stick
    // if(solve(index, matchSticks, side, target))
    // return true
    // side[i]-=stick
    // return false
//    private static boolean makesqaure(int[] matchSticks) {
//
//        int sum = 0;
//
//        for(int stick : matchSticks) {
//            sum += stick;
//        }
//
//        if(sum % 4 != 0) {
//            return false;
//        }
//
//        int target = sum / 4;
//        int[] side = new int[4];
//
//        return solve(0, matchSticks, side, target);
//    }
//
//    private static boolean solve(int index, int[] matchsticks, int[] side, int target) {
//        if(index == matchsticks.length) {
//            return side[0] == target &&
//                   side[1] == target &&
//                   side[2] == target &&
//                   side[3] == target;
//        }
//
//        int stick = matchsticks[index];
//
//        for(int i=0; i<4; i++) {
//            if(side[i] + stick <= target) {
//                side[i]+= stick;
//
//                if(solve(index + 1, matchsticks, side, target)) {
//                    return true;
//                }
//
//                side[i]-= stick;
//            }
//        }
//
//        return false;
//    }
}
