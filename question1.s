.data

input: .asciiz "Original String:  "
str:   .asciiz "able was I ere I saw elba"
count: .asciiz "\nString Count:   "
is:    .asciiz "Given string is PALINDROME"
isnot: .asciiz "Given string is NOT PALINDROME"

.text
.globl main
main:

la $a0, input
li $v0,     4
syscall

la $a0,   str
li $v0,     4
syscall

la $t1, str
li $t0,   0
loop1:
	lb   $t2, 0($t1)
	beqz $t2, exit1
	addi $t1, $t1, 1
	addi $t0, $t0, 1
exit1:

la $a0, count
li $v0,     4
syscall

move $a0, $t0
li $v0,     1
syscall

li $v0, 10
syscall