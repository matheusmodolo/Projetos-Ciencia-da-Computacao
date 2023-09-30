import 'package:aprendendoingles/views/bichos.dart';
import 'package:aprendendoingles/views/numeros.dart';
import 'package:aprendendoingles/views/vogais.dart';
import 'package:flutter/material.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> with SingleTickerProviderStateMixin {
  late TabController _tabController;

  @override
  void initState() {
    super.initState();

    _tabController = TabController(
      length: 3,
      vsync: this,
    );
  }

  @override
  void dispose() {
    super.dispose();
    _tabController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Aprenda Inglês"),
        centerTitle: true,
        bottom: TabBar(
          controller: _tabController,
          indicatorWeight: 4,
          indicatorColor: Colors.white,
          labelStyle: const TextStyle(
            fontSize: 18,
            fontWeight: FontWeight.bold,
          ),
          //labelColor: Colors.black,
          //unselectedLabelColor: Colors.white,
          tabs: const [
            Tab(
              text: "Bichos",
            ),
            Tab(
              text: "Numeros",
            ),
            Tab(
              text: "Vogais",
            )
          ],
        ),
      ),
      body: TabBarView(
        controller: _tabController,
        children: const [
          Bichos(),
          Numeros(),
          Vogais(),
        ],
      ),
    );
  }
}
