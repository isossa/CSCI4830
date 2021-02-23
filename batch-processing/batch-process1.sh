#! /bin/sh 
for f in "$1"/*; do
  if [ -f "$f" ]; then
    WORD_COUNT="$(wc -w "${f}" | cut -d' ' -f1)"
    FILE_SIZE="$(du -sh "${f}" | cut -f1)"
    echo "Processing $f file..."
    echo "File Size: $FILE_SIZE"
    echo "Word Count: $WORD_COUNT"
  fi
done

