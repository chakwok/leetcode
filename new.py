import sys
import re

result = 'Q';
for word in (sys.argv[2:]): 
	result += word
result = re.sub('\.', '', result)
className = re.sub('-','_',result)
print(className)

levels = {
	'e': 'easy', 
	'm': 'medium',
	'h': 'hard'
}
level=levels[sys.argv[1]]

fileName=f"src/{level}/{className}.java"
content=f"package {level};\n\npublic class {className}{{\n}}" 

with open(fileName, 'w') as f:
    f.write(content)