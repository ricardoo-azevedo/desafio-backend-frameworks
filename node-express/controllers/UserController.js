const UserModel = require('../models/UserModel');

class UserController {
    static createUser(req, res) {
        const { name, email } = req.body;

        const user = new UserModel(name, email);

        return res.status(201).json(user);
    }
}

module.exports = UserController;
