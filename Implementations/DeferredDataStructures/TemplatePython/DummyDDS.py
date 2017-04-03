import MetaDDS

class DummyDDS(MetaDDS):

    def __init__(self, list):
        self.list = list

    def rank(self,x):
        count = 0
        for i in self.list:
            if i <= x:
                count = count +1

        return count

    def select(self, r):
        self.list.sort()
        return self.list[r]