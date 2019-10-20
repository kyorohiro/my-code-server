from flask import Flask, request

app = Flask(__name__)

@app.route('/api/v1/hello')
def hello():
    name = request.args.get("name", "World!!")
    return "Hello {}".format(name)

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8080)
