# 193. Valid Phone Numbers
# Read from the file file.txt and output all valid phone numbers to stdout.
cat file.txt | grep -E "(^[0-9]{3}-|^\([0-9]{3}\)\s)[0-9]{3}-[0-9]{4}$"