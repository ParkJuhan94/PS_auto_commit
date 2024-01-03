//package BOJ.Section09.P1138;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Person[] people;
	static Stack<Integer> answer = new Stack<>();
	static Stack<Integer> temp = new Stack<>();

	public static void main(String[] args) throws IOException {
	//	System.setIn(new FileInputStream("src/BOJ/Section09/P1138/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		people = new Person[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = new Person(i, Integer.parseInt(st.nextToken()));
		}

		for (int i = N; i >= 1; i--) {
			int numTallerPeopleAtLeft = people[i].numTallerPeopleAtLeft;
			int diff = answer.size() - numTallerPeopleAtLeft;

			for (int j = 0; j < diff; j++) {
				temp.add(answer.pop());
			}
			answer.add(i);
			while(!temp.isEmpty()){
				answer.add(temp.pop());
			}
		}

		Stack<Integer> reverseAnswer = new Stack<>();
		while(!answer.isEmpty()){
			reverseAnswer.add(answer.pop());
		}

		while(!reverseAnswer.isEmpty()){
			System.out.print(reverseAnswer.pop() + " ");
		}
	}

}

class Person {
	int height;
	int numTallerPeopleAtLeft;

	public Person(int height, int numTallerPeopleAtLeft) {
		this.height = height;
		this.numTallerPeopleAtLeft = numTallerPeopleAtLeft;
	}
}
