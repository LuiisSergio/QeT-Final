import time
from locust import HttpUser, task

class RequestHome(HttpUser):
    @task
    def home(self):
      self.client.verify = False
      self.client.get("", verify=False)