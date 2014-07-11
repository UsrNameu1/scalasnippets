//def containsNeg(nums: List[Int]): Boolean = {
//  var exists = false
//  for (num <- nums)
//    if (num < 0)
//      exists = true
//  exists
//}

def containsNeg(nums: List[Int]) = nums.exists(_ < 0)

containsNeg(List(1, 3, 4, 5))
containsNeg(List(1, -1, 4, -2))

def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)

