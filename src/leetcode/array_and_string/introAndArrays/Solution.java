package leetcode.array_and_string.introAndArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int[] runningSum(int[] nums) {
		// https://leetcode.com/explore/featured/card/the-leetcode-beginners-guide/692/challenge-problems/4422/
		int[] newArray = new int[nums.length];
		int i = 0;
		for (int n : nums) {
			int soFarSum = i == 0 ? 0 : newArray[i - 1];
			newArray[i++] = n + soFarSum;
		}
		return newArray;
	}

	public int maximumWealth(int[][] accounts) {
		// https://leetcode.com/explore/featured/card/the-leetcode-beginners-guide/692/challenge-problems/4423/
		int maxWealth = 0;
		for (int[] eachPersonWealth : accounts) {
			int totalWealth = 0;
			for (int wealthInEachBank : eachPersonWealth) {
				totalWealth += wealthInEachBank;
			}
			maxWealth = maxWealth < totalWealth ? totalWealth : maxWealth;
		}
		return maxWealth;
	}

	public List<String> fizzBuzz(int n) {
		// https://leetcode.com/explore/featured/card/the-leetcode-beginners-guide/692/challenge-problems/4424/
		List<String> listOfStrings = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % (3 * 5) == 0) {
				listOfStrings.add("FizzBuzz");
			} else if (i % (3) == 0) {
				listOfStrings.add("Fizz");
			} else if (i % (5) == 0) {
				listOfStrings.add("Buzz");
			} else {
				listOfStrings.add("" + i);
			}
		}
		return listOfStrings;
	}

	public int numberOfSteps1(int num) {
		int steps = 0;
		while (num > 0) {
			num = (num % 2 == 0) ? num / 2 : (num - 1);
			steps++;
		}
		return steps;
	}

	public int numberOfSteps(int num) {
		// https://leetcode.com/explore/featured/card/the-leetcode-beginners-guide/692/challenge-problems/4425/
		int steps = 0;
		int x = 1;
		while (x <= num) {
			steps = ((x & num) == 0) ? steps + 1 : steps + 2;
			x = x << 1;
		}
		return steps;
	}

	public Map<Character, Integer> characterCount(String str) {
		Map<Character, Integer> chHashMap = new HashMap<>();
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char x = str.charAt(i);
			int val = chHashMap.containsKey(x) ? chHashMap.get(x) : 0;
			val++;
			chHashMap.put(x, val);
		}
		return chHashMap;
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		// https://leetcode.com/explore/featured/card/the-leetcode-beginners-guide/692/challenge-problems/4427/
		Map<Character, Integer> ransomNoteHashMap = characterCount(ransomNote);
		Map<Character, Integer> magazineNoteHashMap = characterCount(magazine);

		for (Map.Entry<Character, Integer> entry : ransomNoteHashMap.entrySet()) {
			Character key = entry.getKey();
			Integer val = entry.getValue();

			Integer valueFromMagazine = magazineNoteHashMap.get(key);
			if (val == valueFromMagazine) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public int findMaxConsecutiveOnes(int[] nums) {
		// https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
		int max = 0;
		int current = 0;
		int len = nums.length;
		int prevElement = nums[0];
		for (int i = 0; i < len; i++) {
			int currentElement = nums[i];
			if (prevElement == currentElement && currentElement == 1) {
				current++;
			} else if (prevElement != currentElement) {
				if (prevElement == 1) { // so current element 0
					current = 0;
				} else { // current element 1
					current++;
				}
			}
			max = max < current ? current : max;
			prevElement = nums[i];
		}

		return max;
	}

	public int digitCounter(int num) {
		if (num < 0) {
			num = num * (-1);
		}

		int counter = 0;
		while (num > 0) {
			num = num / 10;
			counter++;
		}
		return counter;
	}

	public int findNumbers(int[] nums) {
		// https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
		int evenDigitNumbers = 0;
		for (int n : nums) {
			int digitCount = digitCounter(n);
			evenDigitNumbers = (digitCount % 2 == 0) ? evenDigitNumbers + 1 : evenDigitNumbers;
		}

		return evenDigitNumbers;
	}

	public void duplicateZeros(int[] arr) {
		// https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i] == 0) {
				for (int j = len - 1; j >= (i + 2); j--) {
					arr[j] = arr[j - 1];
				}
				if ((i + 1) < len) {
					arr[i + 1] = 0;
				}
				i++;
			} else {
				continue;
			}
		}
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
		int[] nums = new int[n + m];
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < m || j < n) {
			if (i == m && j < n) {
				nums[k++] = nums2[j];
				j++;
			} else if (j == n && i < m) {
				nums[k++] = nums1[i];
				i++;
			} else if (nums1[i] > nums2[j]) {
				nums[k++] = nums2[j];
				j++;
			} else {
				nums[k++] = nums1[i];
				i++;
			}
		}

		for (i = 0; i < n + m; i++) {
			nums1[i] = nums[i];
		}
	}

	public int removeElement(int[] nums, int val) {
		// https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
		int size = nums.length;
		int deletedElements = 0;
		for (int i = 0; i < size; i++) {
			if (nums[i] == val) {
				int j = i + 1;
				for (; j < size; j++) {
					nums[j - 1] = nums[j];
				}
				nums[j - 1] = -1;
				i--;
				deletedElements++;
			}
		}
		return size - deletedElements;
	}

	public int removeDuplicates(int[] nums) {
		// https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/
		int size = nums.length;
		int deletedElements = 0;
		for (int i = 1; i < size; i++) {
			int prevElement = nums[i - 1];

			if (nums[i] == -101)
				break;
			else if (nums[i] == prevElement) {
				int j = i;
				for (; j < size; j++) {
					nums[j - 1] = nums[j];
				}
				nums[j - 1] = -101;
				deletedElements++;
				i--;
			}
		}
		return size - deletedElements;
	}

	public boolean checkIfExist(int[] arr) {
		// https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size && j != i; j++) {
				if (arr[i] == 2 * arr[j])
					return true;
				else if (arr[j] == 2 * arr[i])
					return true;
			}
		}
		return false;
	}

	public boolean validMountainArray(int[] arr) {
		// https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
		int mountainCount = 0;
		int[] slopeArr = new int[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			slopeArr[i - 1] = arr[i] - arr[i - 1];
		}
		for (int i = 1; i < slopeArr.length; i++) {
			int prevSlop = slopeArr[i - 1];
			int currentSlop = slopeArr[i];
			if (prevSlop * currentSlop == 0)
				return false;
			else if (prevSlop < 0 && currentSlop > 0)
				return false;
			else if (prevSlop > 0 && currentSlop < 0)
				mountainCount++;
		}
		return mountainCount == 1;
	}

	public int[] replaceElements(int[] arr) {
		// https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
		for (int i = 0; i < arr.length; i++) {
			int max = -1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > max) {
					max = arr[j];
				}
			}
			arr[i] = max;
		}
		return arr;
	}

	public int removeDuplicate(int[] nums) {
		// https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3258/
		int size = nums.length;
		int deletedElements = 0;
		int i = 0;
		int j = i + 1;
		while (j < size) {
			int currentStagedElement = nums[i];
			if (currentStagedElement == nums[j] && currentStagedElement != -101) {
				deletedElements++;
				nums[j] = -101;
			} else if (currentStagedElement != nums[j] && nums[j - 1] == -101) {
				i++;
				nums[i] = nums[j];
				nums[j] = -101;
			} else {
				i++;
			}
			j++;
		}
		return size - deletedElements;
	}
	
	public void moveZeroes(int[] nums) {
		//https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/
		int size = nums.length;
		int i = 0; 
		int j = i + 1;
		while(j < size) {
			if(nums[i] == 0 && nums[j] == 0) {
				j++;
			} else if(nums[i] != 0 && nums[j] == 0) {
				j++;
				i++;
			} else if(nums[i] == 0 && nums[j] != 0) {
				swap(nums,i, j);
				i++;
				j++;
			} else if(nums[i] != 0 && nums[j] != 0) {
				i++;
				j++;
			}
		}
    }
	
	public void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}
	public boolean checkEven(int num) {
		return num%2 == 0;
	}
	public int[] sortArrayByParity(int[] nums) {
		//https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
		int size = nums.length;
		int i = 0; 
		int j = i + 1;
		while(j < size) {
			if(checkEven(nums[i]) == false && checkEven(nums[j]) == false) {
				j++;
			} else if(checkEven(nums[i]) == true && checkEven(nums[j]) == false) {
				j++;
				i++;
			} else if(checkEven(nums[i]) == false && checkEven(nums[j]) == true) {
				swap(nums,i, j);
				i++;
				j++;
			} else if(checkEven(nums[i]) == true && checkEven(nums[j]) == true) {
				i++;
				j++;
			}
		}
		return nums;
    }
	
	public int heightChecker(int[] heights) {
		//https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3228/
        int size = heights.length;
        int[] heightsCopied = new int[size];
        for(int i = 0; i < size; i++) {
        	heightsCopied[i] = heights[i];
        }
        
        Arrays.sort(heights);
        int swapCounter = 0;
        for(int i = 0; i < size; i++) {
        	if(heightsCopied[i] != heights[i]) {
        		swapCounter++;
        	}
        }
        return swapCounter;
    }
	
	public int findMaxConsecutiveOnes1(int[] nums) {
		//https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3230/
        int[] idxOfZeros = new int[nums.length];
        int j = 0;
        for(int i = 0 ; i < nums.length; i++) {
        	if(nums[i] == 0) {
        		idxOfZeros[j++] = i;
        	}
        }
        
        int max = 0;
        for(int i = 0; i < j ; i++) {
        	int prev = 0;
        	int next = 0;
        	if(i == 0) {
        		prev = idxOfZeros[i];
        	}
        	if(i > 0) {
        		prev = idxOfZeros[i] - idxOfZeros[i - 1] - 1;
        	}
        	if(i == j-1) {
        		next = nums.length - idxOfZeros[i] - 1;
        	}
        	if(i < j - 1) {
        		next = idxOfZeros[i + 1] - idxOfZeros[i] - 1;
        	}
        	
        	int total = 1 + prev + next;
        	if(max < total) {
        		max = total;
        	}
        }
        max = j == 0 ? nums.length : max;
        return max;
    }
	
	
	public int thirdMax(int[] nums) {
		//https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/
		int[] remarks = new int[nums.length];
		//remarks 1st max
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			if(max <= nums[i]) {
				max = nums[i];
			}
		}
		
		int max1 = max;
		
		//remarks 2nd max
		boolean max2Exist = false;
		max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			if(max <= nums[i] && nums[i] != max1) {
				max = nums[i];
				max2Exist = true;
			}
		}
		
		int max2 = max2Exist ? max : max1;
		
		//remarks 3rd max
		boolean max3Exist = false;
		max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			if(max <= nums[i] && nums[i] != max1 && nums[i] != max2) {
				max = nums[i];
				max3Exist = true;
			}
		}
		
		
	
		return max3Exist ? max : max1;
	}
	
	public void alignArray(int[] nums) {
		for(int i = 0 ; i < nums.length; i++) {
			int expected = i + 1;
			int currentElement = nums[i];
			if(currentElement != expected) {
				int j = currentElement - 1;
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
			}
		}
	}
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/solution/
		alignArray(nums);
		alignArray(nums);
		alignArray(nums);
		alignArray(nums);
		alignArray(nums);
		List<Integer> missingInt = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			int expected = i + 1;
			int currentElement = nums[i];
			if(expected != currentElement) {
				missingInt.add(expected);
			}
		}
		return missingInt; 
    }
	
	public List<Integer> findDisappearedNumbersV2(int[] nums) {
		//https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3270/
		List<Integer> missingInts = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			int element = nums[i];
			if(element < 0) {
				int idx = element * (-1) - 1;
				int idxToNum = nums[idx];
				if(idxToNum < 0) {
					continue;
				} else {
					nums[idx] = idxToNum * (-1);
				}
			} else {
				int idx = element - 1;
				int idxToNum = nums[idx];
				if(idxToNum < 0) {
					continue;
				} else {
					nums[idx] = idxToNum * (-1);
				}
			}
		}
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > 0) {
				missingInts.add(i + 1);
			}
		}
		return missingInts;
    }
	
	public int[] sortedSquares(int[] nums) {
		//https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3574/
        List<Integer> listOfNegativeNumbers = new ArrayList<>();
        List<Integer> listOfPositiveNumbers = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] < 0) {
        		listOfNegativeNumbers.add(nums[i] * nums[i]);
        	} else {
        		listOfPositiveNumbers.add(nums[i] * nums[i]);
        	}
        }
        //its time to merge two sorted ARRAY
        
        int negativeArraySize = listOfNegativeNumbers.size();
        int positiveArraySize = listOfPositiveNumbers.size();
        
        int i = negativeArraySize - 1;
        int j = 0;
        int k = 0;
        
        while(k < nums.length) {
        	if(i >= 0 && j < positiveArraySize) {
        		if(listOfNegativeNumbers.get(i) < listOfPositiveNumbers.get(j)) {
        			nums[k] = listOfNegativeNumbers.get(i);
        			i--;
        		} else {
        			nums[k] = listOfPositiveNumbers.get(j);
        			j++;
        		}
        	} else if(i < 0 && j < positiveArraySize) {
        		nums[k] = listOfPositiveNumbers.get(j);
				j++;
        	} else if(i >= 0 && j >= positiveArraySize) {
        		nums[k] = listOfNegativeNumbers.get(i);
    			i--;
        	}
        	k++;	
        }
		return nums;
    }
}
