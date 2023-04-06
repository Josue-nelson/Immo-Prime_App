'use strict';

/**
 * quartier service
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::quartier.quartier');
