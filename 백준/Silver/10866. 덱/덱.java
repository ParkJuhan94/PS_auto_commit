import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        // 갱신이 많으니까 sb를 쓰자.
		StringBuffer sb = new StringBuffer();
		Deque<Integer> deque = new LinkedList<>();
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String cmd = sc.next();

			switch (cmd) {
			case "push_front": {
				deque.addFirst(sc.nextInt());
				break;
			}
			case "push_back": {
				deque.addLast(sc.nextInt());
				break;
			}
			case "pop_front": {
				if (deque.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deque.removeFirst()).append('\n');
				}
				break;
			}
			case "pop_back": {
				if (deque.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deque.removeLast()).append('\n');
				}
				break;
			}
			case "size": {
				sb.append(deque.size()).append('\n');
				break;
			}
			case "empty": {
				if (deque.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			}
			case "front": {
				if (deque.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deque.peekFirst()).append('\n');
				}
				break;
			}
			case "back": {
				if (deque.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deque.peekLast()).append('\n');
				}
				break;
			}
			default:
				break;
			}
		}
               
		System.out.println(sb);
        
        
	}
}