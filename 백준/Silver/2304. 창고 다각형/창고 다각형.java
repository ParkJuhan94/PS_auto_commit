//package BOJ.Section08.P2304;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int L;
	static int H;
	static int maxH = 0;
	static int standardIdx = 0;
	static List<Pole> poles = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/BOJ/Section08/P2304/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			Pole pole = new Pole(L, H);
			poles.add(pole);

			maxH = Math.max(maxH, H);
		}
		Collections.sort(poles);
		// poles 의 인덱스 셋팅
		for (int i = 0; i < poles.size(); i++) {
			poles.get(i).idx = i;
			if (poles.get(i).H == maxH) {
				standardIdx = i;
			}
		}

		int sumForMinus = 0;
		int sumL = 0;
		int curMaxH = poles.get(0).H;
		// 왼쪽에서 젤 높은 막대까지 이동
		for (int i = 1; i <= standardIdx; i++) {
			Pole pre = poles.get(i - 1);
			Pole cur = poles.get(i);

			if (cur.H > curMaxH) {
				sumL += cur.L - pre.L;
				// System.out.println(sumL * (maxH - curMaxH));
				sumForMinus += sumL * (maxH - curMaxH);
				sumL = 0;
				curMaxH = cur.H;
			} else {
				sumL += cur.L - pre.L;
			}
		}

		curMaxH = poles.get(N - 1).H;
		sumL = 0;
		// 오른쪽에서 젤 높은 막대까지 이동
		for (int i = N - 2; i >= standardIdx; i--) {
			Pole pre = poles.get(i + 1);
			Pole cur = poles.get(i);

			if (poles.get(i).H > curMaxH) {
				sumL += pre.L - cur.L;
				// System.out.println(sumL * (maxH - curMaxH));
				sumForMinus += sumL * (maxH - curMaxH);
				sumL = 0;
				curMaxH = cur.H;
			} else {
				sumL += pre.L - cur.L;
			}
		}

		// 큰 사각형 - 뺄 사각형
		int minL = poles.get(0).L;
		int maxL = poles.get(N - 1).L;
		int answer = maxH * (maxL - minL + 1) - sumForMinus;
		System.out.println(answer);
	}

	static class Pole implements Comparable<Pole> {
		int idx;
		int L;
		int H;

		public Pole(int l, int h) {
			L = l;
			H = h;
		}

		@Override
		public int compareTo(Pole o) {
			return L - o.L;
		}
	}
}
