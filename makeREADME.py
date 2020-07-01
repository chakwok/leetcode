import re
import datetime

easy = 0
medium = 0
hard = 0

def main():
	summarize()
	logEntry()
	copyTheWholeFile()


def copyTheWholeFile():
	with open("db.md", 'r') as f, open("README.md", 'a') as o:
		o.write("\n\n")
		for line in f.readlines():
			if(len(line) > 1 and line[0] == '#'):
				continue
			if(re.match('[1-9].', line)):
				o.write('_' + line);
			else:
				o.write(line)


def summarize():
	with open("db.md", 'r') as f, open("README.md", 'w') as o:
		state = 'easy'
		global easy
		global medium
		global hard
		for line in f.readlines():
			if (line.strip() == '**medium**'):
				state = 'medium'
			elif (line.strip() == '**hard**'):
				state = 'hard'
			else:
				if(re.match('\d+\.', line)):
					if(state == 'easy'):
						easy += 1
					elif(state == 'medium'):
						medium +=1
					elif (state == 'hard'):
						hard += 1
			


		
		total = easy + medium + hard
		o.write("# leetcode\n")
		o.write("**Total Problem Solved: {}**\n".format(total))
		o.write("* easy: {}\n".format(easy))
		o.write("* medium: {}\n".format(medium))
		o.write("* hard: {}\n".format(hard))

def logEntry():
	with open("db.md", 'a') as o:
		o.write("\n* {}: {}-{}-{} | sum: {}".format(datetime.date.today(), easy, medium, hard, (easy + medium + hard)))

main()

