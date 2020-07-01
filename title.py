import sys
import re

result = 'Q';
for word in (sys.argv[1:]): 
	result += word
result = re.sub('\.', '', result)
print(re.sub('-','_',result))