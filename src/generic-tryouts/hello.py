print 'Hello, world!'

# 1 Types of print statements

n = raw_input('Name is -')
print 'Hi, %s'%n
print 'Name2 is'+ raw_input('Name2 is -')
t = 'test'
print t ,'hardcoded'

# 2 for loops
ar = ['a','b']
for i,name in enumerate(ar):
	print "i is {i},value is {name}".format(i=i,name=name)

# 3 fibonacci
parents, babies = (1, 1)
while babies < 100:
    print 'This generation has {0} babies'.format(babies)
    parents, babies = (babies, parents + babies)  # elements refers to previous state

# 4 funs
def test_fun(a):
	print a

test_fun('arun')

# 5 import libs
import re

for t in ['12','13']:
	if re.match(r'^\d{2}$',t):
		print t, 'is matching'
	else:
		print t, 'is not matching'

# 6 high-level iteration
price = {'badam':2.1,'spices':1.1}
my_purchase = {'badam':2,'spices':1}

bill = sum(my_purchase[fruit] * price[fruit] for fruit in my_purchase)

print 'Rs.%.2f' % bill

# 7 sum of Cmd line args
#!/usr/bin/env python

import sys

try:
	tot = sum (int(arg) for arg in sys.argv[1:])
	print 'sum is ',tot
except ValueError:
	print 'Please supply integer only'


# 8 file operatoins

import glob

a = glob.glob('*.py')

for file in sorted(a):
	print ' -----'+file

	with open(file) as f:
		for line in f:
			print '    '+line.rstrip()

	print


