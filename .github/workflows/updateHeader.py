import sys
import os
import re


headerFormat = '''/*
 * {id}. {name}
 * Problem Link: {link}
 * Difficulty:   {difficulty}
 * 
 * Solution Created by: Muhammad Khuzaima Umair
 * LeetCode : https://leetcode.com/mkhuzaima/
 * Github   : https://github.com/mkhuzaima
 * LinkedIn : https://www.linkedin.com/in/mkhuzaima/
 */
'''


def updateHeader(file):
    # read
    with open(file, 'r') as f:
        lines = f.readlines()

    
    # get the id
    id = re.search(r'// id: (\d+)', lines[0], re.IGNORECASE).group(1)
    # get the name
    name = re.search(r'// Name: (.+)', lines[1], re.IGNORECASE).group(1)
    # get the link
    link = re.search(r'// link: (.+)', lines[2], re.IGNORECASE).group(1)
    # get the difficulty
    difficulty = re.search(r'// Difficulty: (.+)', lines[3], re.IGNORECASE).group(1)

    # update the header
    header = headerFormat.format(id=id, name=name, link=link, difficulty=difficulty)

    # modify the file in place
    with open(file, 'w') as f:
        f.write(header)
        f.writelines(lines[4:])


if __name__ == '__main__':
    filename = sys.argv[1]

    # check if the file exists
    if not os.path.exists(filename):
        print('File does not exist')

    # check if the file is a java file
    if not filename.endswith('.java'):
        print('File is not a java file')

    try:
        # update the header
        updateHeader(filename)
        print(f'Updated {filename}')
    except:
        print(f'Something went wrong while updating {filename}')
