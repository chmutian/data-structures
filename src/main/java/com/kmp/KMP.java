package com.kmp;

/**
 * KMP算法
 *
 */
public class KMP {

	public static void main(String args[]) {
		System.out.println(kmp("ffababffababccddccaabbggg", "ababccddccaabb"));
	}

	private static boolean kmp(String target, String pattern) {

		int[] partialMatchTable = createPartialMatchTable(pattern);

		char[] targetCharArr = target.toCharArray();
		char[] patternCharArr = pattern.toCharArray();

		int j = 0;// 模式串位置
		int matchCharCounts = 0;// 记录下已经匹配的字符的个数
		for (int i = 0; i < targetCharArr.length; i++) {
			// 如果当前主串和子串的字符匹配上了 那么比较下一个字符是否匹配
			if (targetCharArr[i] == patternCharArr[j]) {
				j++;
				matchCharCounts++;
				// 如果匹配成功了 直接返回true了
				if (j == patternCharArr.length - 1) {
					return true;
				} else {
					continue;
				}
			}
			// 如果子串的第一个元素都不和主串的元素相等 那么就拿主串的下一个元素进行比较
			if (j == 0) {
				continue;
			}
			// 如果子串不是在第一个元素的位置而是在其他位置进行了失配，那么进行移位操作
			// 移动位数 = 已匹配的字符数 - 对应的部分匹配值
			// 对应匹配值 指的是最后一个字符的对应匹配值 j是失配的位置 所以这里是partialMatchTable[j - 1]
			int moveCounts = matchCharCounts - partialMatchTable[j - 1];
			j = j - moveCounts;// 移动模式串 往前移moveCounts 位
			matchCharCounts = matchCharCounts - moveCounts;// 修改匹配的字符个数，就是减去移动过的位数
		}

		return false;
	}

	private static int[] createPartialMatchTable(String pattern) {
		if (pattern == null) {
			throw new RuntimeException("pattern is null");
		}
		int patternLen = pattern.length();
		int[] matchTable = new int[patternLen];

		for (int i = 0; i < matchTable.length; i++) {
			if (i == 0) {
				matchTable[0] = 0;
			} else {
				int matchValue = calcMatchLength(pattern.substring(0, i + 1));
				matchTable[i] = matchValue;
			}
		}

		return matchTable;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	private static int calcMatchLength(String str) {
		if (str == null || str.length() == 1) {
			return 0;
		}

		String prefix = str.substring(0, str.length() - 1);
		String suffix = str.substring(1);
		for (int i = 1; i <= str.length(); i++) {
			prefix = str.substring(0, str.length() - i);
			suffix = str.substring(i);
			if (prefix.equals(suffix)) {
				return prefix.length();
			}
		}
		return 0;
	}

}
