   PROGRAM 8
   LDGADDR 0
   LDCINT 5
   STOREW
   LDGADDR 4
   LDCINT 0
   STOREW
   LDGADDR 4
   LOADW
   LDCINT 0
   CMP
   BNZ L4
   LDCB 0
   BR L5
L4:
   LDGADDR 0
   LOADW
   LDGADDR 4
   LOADW
   DIV
   LDCINT 10
   CMP
   BGE L2
   LDCB 1
   BR L3
L2:
   LDCB 0
L3:
L5:
   BZ L6
   LDGADDR 0
   LOADW
   PUTINT
   PUTEOL
   BR L7
L6:
   LDGADDR 4
   LOADW
   PUTINT
   PUTEOL
L7:
   HALT
