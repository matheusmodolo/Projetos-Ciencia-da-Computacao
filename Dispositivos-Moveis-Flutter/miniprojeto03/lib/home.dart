import 'package:flutter/material.dart';
import 'package:miniprojeto03/main.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  GlobalKey<FormState> _formkey = GlobalKey<FormState>();
  TextEditingController _gasController = TextEditingController();
  TextEditingController _etController = TextEditingController();
  String _resultado = "";

  void _calcular() {
    if (_formkey.currentState!.validate()) {
      double gas = double.parse(_gasController.text);
      double et = double.parse(_etController.text);

      if ((et / gas) >= 0.7) {
        setState(() {
          _resultado = "Melhor Gasolina";
        });
      } else {
        setState(() {
          _resultado = "Melhor Etanol";
        });
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.amber.shade900,
      appBar: AppBar(
        centerTitle: true,
        title: const Text("Gasolina ou Etanol"),
        backgroundColor: Colors.amber.shade800,
      ),
      body: Form(
        key: _formkey,
        child: Center(
          child: SingleChildScrollView(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                Image.asset(
                  "images/gas_et.png",
                  fit: BoxFit.fill,
                ),
                const SizedBox(
                  height: 32,
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 16),
                  child: TextFormField(
                    controller: _gasController,
                    keyboardType: TextInputType.number,
                    decoration: InputDecoration(
                      hintText: " 5.999",
                      labelText: "Preço da Gasolina",
                      labelStyle: const TextStyle(
                        color: Colors.white,
                        fontSize: 24,
                      ),
                      focusedBorder: UnderlineInputBorder(
                        borderSide: BorderSide(
                          color: Colors.amber.shade500,
                        ),
                      ),
                    ),
                    cursorColor: Colors.white,
                    style: const TextStyle(
                      color: Colors.white,
                      fontSize: 24,
                    ),
                    validator: (text) {
                      return (text!.isEmpty || double.parse(text) <= 0)
                          ? "Obrigatório e valores maiores do que 0"
                          : null;
                    },
                  ),
                ),
                const SizedBox(
                  height: 60,
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 16),
                  child: TextFormField(
                    controller: _etController,
                    keyboardType: TextInputType.number,
                    decoration: InputDecoration(
                      hintText: " 5.999",
                      labelText: "Preço do Etanol",
                      labelStyle: const TextStyle(
                        color: Colors.white,
                        fontSize: 24,
                      ),
                      focusedBorder: UnderlineInputBorder(
                        borderSide: BorderSide(
                          color: Colors.amber.shade500,
                        ),
                      ),
                    ),
                    cursorColor: Colors.white,
                    style: const TextStyle(
                      color: Colors.white,
                      fontSize: 24,
                    ),
                    validator: (text) {
                      return (text!.isEmpty || double.parse(text) <= 0)
                          ? "Obrigatório e valores maiores do que 0"
                          : null;
                    },
                  ),
                ),
                const SizedBox(
                  height: 40,
                ),
                ElevatedButton(
                  onPressed: _calcular,
                  child: const Text(
                    "calcular",
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 24,
                    ),
                  ),
                  style: ElevatedButton.styleFrom(
                    primary: Colors.amber,
                  ),
                ),
                Align(
                  alignment: Alignment.center,
                  child: Padding(
                    padding:
                        const EdgeInsets.only(top: 32, left: 16, right: 16),
                    child: Text(
                      _resultado,
                      style: const TextStyle(
                        color: Colors.white,
                        fontSize: 24,
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
