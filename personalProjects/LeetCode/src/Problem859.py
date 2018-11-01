author = 'matt'
class Solution(object):
    """
    :type A: str
    :type B: str
    :rtype: bool
    """
    def buddyStrings(self, A, B):
        if not self.stringsAreAnagrams(A, B):
            return False
        differingCharIndicesList = self.getDifferingCharsIndicesList(A, B)
        if len(differingCharIndicesList) > 2:
            #if our anagrams differ by more than 2 positions
            return False
        elif len(differingCharIndicesList) == 2:
            #swap our two indices in A and return if A.equals(B)
            aCharList = list(A)
            firstIndexofDiffrentChar = differingCharIndicesList[0]
            secondIndexofDiffrentChar = differingCharIndicesList[1]

            aCharList.insert(firstIndexofDiffrentChar,aCharList[secondIndexofDiffrentChar])
            firstDiffrentChar = aCharList[firstIndexofDiffrentChar + 1]
            aCharList.pop(firstIndexofDiffrentChar + 1)
            aCharList[secondIndexofDiffrentChar] = firstDiffrentChar
            return (B) == ("".join(aCharList))
        #todo edge cases
        aCharList = list(A)
        if len(aCharList) < 2:
            return False
        elif len(aCharList) == 2:
            return "".join(aCharList[1] + aCharList[0]) == B
        if self.getFirstOccuranceofRepeatedChar(A) is None:
            return False
        return True


    """
    returns the first repeted char in a provided string; None if no repeating chars
    """
    def getFirstOccuranceofRepeatedChar(self, stringToCheck):
        listofLetters = list()
        for char in stringToCheck:
            if char not in listofLetters:
                listofLetters.append(char)
            else:
                return char
        return None
    """
    returns a list of indices of differing characters between two anagrams
    precondition: A and B are anagrams
    :type A: str
    :type B: str
    :rtype: List<int>
    """
    def getDifferingCharsIndicesList(self, A, B):
        aCharList = list(A)
        bCharList = list(B)

        differingCharIndicesList = list()

        for i in range(len(aCharList)):
            if(aCharList[i] != bCharList[i]):
                differingCharIndicesList.append(i)
        return differingCharIndicesList


    """
    :type A: str
    :type B: str
    :rtype: bool
    """
    def stringsAreAnagrams(self, A, B):
        aCharList = list(A)
        bCharList = list(B)

        aCharList.sort()
        bCharList.sort()
        for i in range(len(aCharList)):
            if(aCharList[i] != bCharList[i]):
                #if sorted char lists differ then these strings are not anagrams
                return False

        return True
