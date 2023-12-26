
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

class Solution {
	List<Log> logs = new ArrayList<>();

	public int solution(String[] lines) {
		int answer = 0;

		initialLogs(lines);

		for (int i = 0; i < logs.size(); i++) {
			int numTask = 1;
			Log curLog = logs.get(i);

			for (int j = i + 1; j < logs.size(); j++) {
				Log nextLog = logs.get(j);
				if (curLog.end.getTime() > nextLog.start.getTime() - 1000) {
					numTask++;
				}
			}

			answer = Math.max(answer, numTask);
		}

		return answer;
	}

	private void initialLogs(String[] lines) {
		for (String line : lines) {
			String[] query = line.split(" ");

			String strEnd = query[0] + " " + query[1];
			String strDuration = query[2];

			Timestamp end = Timestamp.valueOf(strEnd);

			strDuration = strDuration.substring(0, strDuration.length() - 1);
			long duration = (long)(Double.parseDouble(strDuration) * 1000 - 1);
			System.out.println(duration);
			Timestamp start = new Timestamp(end.getTime() - duration);

			logs.add(new Log(start, end));
		}
	}
}

class Log {
	Timestamp start;
	Timestamp end;

	public Log(Timestamp start, Timestamp end) {
		this.start = start;
		this.end = end;
	}
}
