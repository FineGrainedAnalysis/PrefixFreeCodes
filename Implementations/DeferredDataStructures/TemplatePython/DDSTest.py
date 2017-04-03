from DummyDDS import DummyDDS
from MyDDS import MyDDS
import unittest

class DDSTest(unittest.TestCase):

    def setUp(self):
        testList = []
        self.dummyDDS = DummyDDS(testList)
        self.myDDS = MyDDS(testList)


    def test_rank(self):
        self.assertEqual(self.dummyDDS.rank(1), self.myDDS.rank(1))

    def test_select(self):
        self.assertEqual(self.dummyDDS.select(1), self.myDDS.select(1))


if __name__ == '__main__':
    unittest.main()
